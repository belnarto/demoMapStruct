package com.example.demomapstruct;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demomapstruct.dto.PostDto;
import com.example.demomapstruct.dto.UserDto;
import com.example.demomapstruct.entity.PostEntity;
import com.example.demomapstruct.entity.UserEntity;
import com.example.demomapstruct.enums.AmazonSettingSyncPriceType;
import com.example.demomapstruct.enums.Gender;
import com.example.demomapstruct.mapper.UserMapper;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoMapStructApplicationTests {

    @Test
    void contextLoads() {
    }

    @RepeatedTest(100)
    void mapUserDtoToEntity() {
        UserDto userDto = UserDto.builder()
            .id(RandomUtils.nextLong())
            .mainAddress(getSmallRandomString())
            .name(getSmallRandomString())
            .surname(getSmallRandomString())
            .email(getSmallRandomString())
            .age(RandomUtils.nextInt())
            .gender(Gender.values()[RandomUtils.nextInt(0, Gender.values().length)])
            .accountBalance(RandomUtils.nextDouble())
            .birthDate(Instant.ofEpochSecond(RandomUtils.nextInt(0, Integer.MAX_VALUE)).atZone(ZoneId.systemDefault())
                .toLocalDate())
            .created(Instant.ofEpochSecond(RandomUtils.nextInt(0, Integer.MAX_VALUE)))
            .amazonSettingSyncPriceType(
                AmazonSettingSyncPriceType.values()[RandomUtils.nextInt(0, AmazonSettingSyncPriceType.values().length)])
            .properties(
                Map.of(getSmallRandomString(), getSmallRandomString(), getSmallRandomString(), getSmallRandomString()))
            .tags(List.of(getSmallRandomString(), getSmallRandomString(), getSmallRandomString()))
            .posts(List.of(getRandomPostDto(), getRandomPostDto(), getRandomPostDto()))
            .build();
        UserEntity userEntity = UserMapper.MAPPER.convert(userDto);
        assertThat(userEntity)
            .matches(e -> e.getId() == userDto.getId())
            .matches(e -> e.getAddress().equals(userDto.getMainAddress()))
            .matches(e -> e.getName().equals(userDto.getName()))
            .matches(e -> e.getSurname().equals(userDto.getSurname()))
            .matches(e -> e.getEmail().equals(userDto.getEmail()))
            .matches(e -> e.getAge() == userDto.getAge())
            .matches(e -> e.getGender().equals(userDto.getGender()))
            .matches(e -> e.getAccountBalance() == userDto.getAccountBalance())
            .matches(e -> e.getBirthdate().equals(userDto.getBirthDate()))
            .matches(e -> e.getCreatedAt().equals(userDto.getCreated()))
            .matches(e -> e.getAmazonSettingSyncPriceType() == userDto.getAmazonSettingSyncPriceType().getType())
            .matches(e -> e.getProperties().equals(userDto.getProperties()))
            .matches(e -> e.getProperties() != userDto.getProperties())
            .matches(e -> e.getTags().equals(userDto.getTags()))
            .matches(e -> e.getTags() != userDto.getTags())
            .matches(e -> e.getPosts().size() == userDto.getPosts().size())
            .matches(e -> postEntitiesMatchPostDtos(e.getPosts(), userDto.getPosts()));
    }

    @RepeatedTest(100)
    void mapUserEntityToDto() {
        UserEntity userEntity = UserEntity.builder()
            .id(RandomUtils.nextLong())
            .address(getSmallRandomString())
            .name(getSmallRandomString())
            .surname(getSmallRandomString())
            .email(getSmallRandomString())
            .age(RandomUtils.nextInt())
            .gender(Gender.values()[RandomUtils.nextInt(0, Gender.values().length)])
            .accountBalance(RandomUtils.nextDouble())
            .birthdate(Instant.ofEpochSecond(RandomUtils.nextInt(0, Integer.MAX_VALUE)).atZone(ZoneId.systemDefault())
                .toLocalDate())
            .createdAt(Instant.ofEpochSecond(RandomUtils.nextInt(0, Integer.MAX_VALUE)))
            .amazonSettingSyncPriceType(AmazonSettingSyncPriceType.values()[RandomUtils.nextInt(0,
                AmazonSettingSyncPriceType.values().length)].getType())
            .properties(
                Map.of(getSmallRandomString(), getSmallRandomString(), getSmallRandomString(), getSmallRandomString()))
            .tags(List.of(getSmallRandomString(), getSmallRandomString(), getSmallRandomString()))
            .build();
        UserDto userDto = UserMapper.MAPPER.convert(userEntity);
        assertThat(userDto)
            .matches(e -> e.getId() == userEntity.getId())
            .matches(e -> e.getMainAddress().equals(userEntity.getAddress()))
            .matches(e -> e.getName().equals(userEntity.getName()))
            .matches(e -> e.getSurname().equals(userEntity.getSurname()))
            .matches(e -> e.getEmail().equals(userEntity.getEmail()))
            .matches(e -> e.getAge() == userEntity.getAge())
            .matches(e -> e.getGender().equals(userEntity.getGender()))
            .matches(e -> e.getAccountBalance() == userEntity.getAccountBalance())
            .matches(e -> e.getBirthDate().equals(userEntity.getBirthdate()))
            .matches(e -> e.getCreated().equals(userEntity.getCreatedAt()))
            .matches(e -> e.getAmazonSettingSyncPriceType().getType() == userEntity.getAmazonSettingSyncPriceType())
            .matches(e -> e.getProperties().equals(userEntity.getProperties()))
            .matches(e -> e.getProperties() != userEntity.getProperties())
            .matches(e -> e.getTags().equals(userEntity.getTags()))
            .matches(e -> e.getTags() != userEntity.getTags());
    }

    private static String getSmallRandomString() {
        return RandomStringUtils.random(RandomUtils.nextInt(1, 10));
    }

    private static PostDto getRandomPostDto() {
        return PostDto.builder()
            .id(RandomUtils.nextLong())
            .likesCount(RandomUtils.nextLong())
            .build();
    }

    private static boolean postEntitiesMatchPostDtos(Collection<PostEntity> postEntities,
        Collection<PostDto> postDtos) {
        return postEntities.stream()
            .allMatch(postEntity -> postDtos.stream()
                .anyMatch(p -> p.getId() == postEntity.getId() &&
                    p.getLikesCount() == postEntity.getLikes()));
    }

}

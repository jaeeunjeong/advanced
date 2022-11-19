package learning.mapStruct;

import hello.advanced.mapStruct.Person;
import hello.advanced.mapStruct.PersonDto;
import hello.advanced.mapStruct.PersonMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    @Test
    public void dtoToEntity() {
        // given
        PersonDto personDto = PersonDto.builder()
                .id(1L)
                .name("JAEEUN")
                .email("JAEEUN@gmail.com")
                .birth("1999-99-99")
                .build();

        // when
        Person person = PersonMapper.INSTANCE.toEntity(personDto);

        // then
        assertEquals(personDto.getEmail(), person.getEmail());
        assertEquals(personDto.getTeam(), person.getGroup());
    }

    @DisplayName("entity를 dto로 만들기")
    @Test
    public void test2() {
        // given
        Person person = Person.builder()
                .id(1L)
                .name("EUNJAE")
                .email("EUNJAE@gmail.com")
                .birth("2000-01-01")
                .build();

        // when
        PersonDto personDto = PersonMapper.INSTANCE.toDto(person);

        // then
        assertEquals(person.getName(), personDto.getName());
        assertEquals(person.getBirth(), personDto.getBirth());
    }
}
package hello.advanced.mapStruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    //
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    /**
     * dto를 entity로 만들기
     * @param personDto
     * @return
     */
    @Mapping(target = "id", ignore = true) // entity로 변환시 id는 제외한다.
    @Mapping(source = "team", target= "group") // PersonTeam.team을 Person.group으로 맵핑한다.
     // Person.createDate를 java(java.time.LocalDateTime.now()로 초기화한다.
    @Mapping(target = "createDate", expression = "java(java.time.LocalDateTime.now())")
    Person toEntity(PersonDto personDto);

    /**
     * entity를 dto로 만들기.
     * @param person
     * @return
     */
    @Mapping(source = "group", target = "team") // Person.group을 PersonDto.team에 넣는다.
    PersonDto toDto(Person person);
}
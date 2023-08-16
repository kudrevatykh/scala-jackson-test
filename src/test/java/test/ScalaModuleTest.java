package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.scala.DefaultScalaModule$;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScalaModuleTest {

    @Test
    public void testScalaModule() throws JsonProcessingException {
        var json = "{\"value\": \"a@b\"}";
        var mapper = new ObjectMapper().registerModule(DefaultScalaModule$.MODULE$);
        var val = mapper.readValue(json, DataWrapper.class);
        Assertions.assertEquals(new Data("a", "b"), val.value);
    }

    @Test
    public void testPlainJackson() throws JsonProcessingException {
        var json = "{\"value\": \"a@b\"}";
        var mapper = new ObjectMapper();
        var val = mapper.readValue(json, DataWrapper.class);
        Assertions.assertEquals(new Data("a", "b"), val.value);
    }
}

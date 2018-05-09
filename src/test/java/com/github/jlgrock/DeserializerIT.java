package com.github.jlgrock;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 *
 */
public class DeserializerIT {

    private ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());
    private Deserializer deserializer = new Deserializer(objectMapper);

    String jsonIn =
            "{" +
            "   \"version\": 1.2," +
            "   \"name\": \"Justin Grant\"," +
            "   \"phone\": \"313-212-1122\"" +
            "}";
    @Test
    public void test_deserializeWithNoBuilder() throws Exception {
        TestRecord myRecord = new TestRecord();
        myRecord.setName("Justin Grant");
        myRecord.setPhone("313-212-1122");

        TestRecord outputRecord = deserializer.deserialize(jsonIn, TestRecord.class, TestRecord.class);

        assertEquals(myRecord, outputRecord);
    }

    @Test
    public void test_deserializeWithBuilder() throws Exception {
        TestRecordWithBuilder myRecord = TestRecordWithBuilder.builder()
                .withName("Justin Grant")
                .withPhone("313-212-1122")
                .build();

        TestRecordWithBuilder outputRecord = deserializer.deserialize(jsonIn, TestRecordWithBuilder.Builder.class, TestRecordWithBuilder.class);

        assertEquals(myRecord, outputRecord);
    }

}

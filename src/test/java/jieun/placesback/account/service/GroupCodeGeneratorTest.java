package jieun.placesback.account.service;


import jieun.placesback.account.repository.GroupRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GroupCodeGeneratorTest {
    @Mock
    GroupRepository groupRepository;
    @InjectMocks
    GroupCodeGenerator groupCodeGenerator;

    @Autowired
    ResourceLoader resourceLoader;

    @Test
    void code_can_not_be_used_more_than_once () throws IOException {
        // given, code which lasts 24h
        String code = "london";

        // when, code is used
//        when(groupRepository.isUsedCode(code)).thenReturn(true);

        // then
        assertEquals(new String(), groupCodeGenerator.getGroupCode());
    }

    @Test
    void code_is_random() throws IOException {
//        // given, first
//        List<String> codes = new ArrayList<>();
//        Resource resource = resourceLoader.getResource("classpath:static/group_code/cities.csv");
//        InputStream inputStream = resource.getInputStream();
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                for (String code: line.split(","))
//                codes.add(code);
//            }
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        int randomNumber = ThreadLocalRandom.current().nextInt(0, codes.size());
//        String oldCode = codes.get(randomNumber);
//        // then, second
//
//        randomNumber = ThreadLocalRandom.current().nextInt(0, codes.size());
//        String newCode = codes.get(randomNumber);
//        assertNotEquals(oldCode, newCode);
    }
}

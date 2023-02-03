package jieun.placesback.account.service;

import jieun.placesback.account.repository.GroupCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class GroupCodeGenerator {
    private final GroupCodeRepository groupCodeRepository;
    private final ResourceLoader resourceLoader;
    private List<String> codes = new ArrayList<>();

    public String getGroupCode() throws IOException {
        String code = generateCode();
        if (groupCodeRepository.isUsedCode(code)) {
            return new String();
        }
        return code;
    }

    private String generateCode() throws IOException {
        initGroupCodes();
        int randomNumber = ThreadLocalRandom.current().nextInt(0, codes.size());
        return codes.get(randomNumber);
    }

    private void initGroupCodes() throws IOException {
        if (codes.size() > 0) {
            return;
        }
        InputStream inputStream = resourceLoader.getResource("classpath:static/group_code/cities.csv").getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        String line;
        while ((line = reader.readLine()) != null) {
            for (String code: line.split(","))
                codes.add(code);
        }
    }
}

package com.siksaurus.yamstack;

import com.siksaurus.yamstack.account.domain.AccountRole;
import com.siksaurus.yamstack.global.security.JwtAuthTokenProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
public class ControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected JwtAuthTokenProvider jwtAuthTokenProvider;

    protected String makeJwtAuthToken(AccountRole role, Date expiredDate) {
        return jwtAuthTokenProvider.createAuthToken("test",role, expiredDate).getToken();
    }


    @BeforeEach
    void setup(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation)
                        .uris()
                        .withScheme("https")
                        .withHost("api.yamstack.com") //todo 도메인 정해지면 변경 필요
                        .withPort(80)
                )
                .alwaysDo(document("{method-name}"
                        , preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint())))
                .build();
    }
}
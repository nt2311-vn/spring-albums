package com.packt.albums;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {"football.api.url=http://localhost:7979"})
public class FootballClientServiceTest {
  private static WireMockServer wireMockServer;

  @BeforeAll
  static void init() {
    wireMockServer = new WireMockServer(7979);
    wireMockServer.start();
    WireMock.configureFor(7979);
  }

  @Autowired FootballClientService footballClientService;

  @Test
  public void getPlayerTest() {
    WireMock.stubFor(
        WireMock.get(WireMock.urlEqualTo("/players/32656"))
            .willReturn(
                WireMock.aResponse()
                    .withHeader("Content-Type", "application/json")
                    .withBody(
                        """
                        {
                          "id": "325636",
                          "jerseyNumber": 11,
                          "name": "Alexia PUTELLAS",
                          "position": "Midfielder",
                          "dateOfBirth": "1994-02-04"
                        }
                        """)));
  }
}

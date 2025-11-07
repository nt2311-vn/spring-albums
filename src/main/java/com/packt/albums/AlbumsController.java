package com.packt.albums;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/albums")
public class AlbumsController {
  private final FootballClient footballClient;

  public AlbumsController(FootballClient footballClient) {
    this.footballClient = footballClient;
  }
}

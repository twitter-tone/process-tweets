package twitter.process;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

public class Tone {
  @JsonbProperty("score")
  public Double score;

  @JsonbProperty("tone_id")
  public String tone_id;

  @JsonbProperty("tone_name")
  public String tone_name;

  public Tone() {
    
  }

  @JsonbCreator
  public Tone(
    @JsonbProperty("score") Double score,
    @JsonbProperty("tone_id") String tone_id,
    @JsonbProperty("tone_name") String tone_name) {

    this.score = score;
    this.tone_id = tone_id;
    this.tone_name = tone_name;
  }

  public String getTone() {
    return tone_name;
  } 

}

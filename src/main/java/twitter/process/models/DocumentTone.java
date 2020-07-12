package twitter.process;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

public class DocumentTone {
  @JsonbProperty("tones")
  public Tone tones[];

  public DocumentTone() {
    
  }

  @JsonbCreator
  public DocumentTone(
    @JsonbProperty("tones") Tone tones[]) {

      this.tones = tones;
  }
}

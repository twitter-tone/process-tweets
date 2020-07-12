package twitter.process;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

public class ToneResponse { 
  @JsonbProperty("document_tone")
  public DocumentTone tone;

  public ToneResponse() {

  }

  @JsonbCreator
  public ToneResponse(
    @JsonbProperty("document_tone") DocumentTone tone) {

      this.tone = tone;
  }

}

package org.android.gcm;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 Content class of type JSON.
 e.g:
{ "collapse_key": "score_update",
  "time_to_live": 108,
  "delay_while_idle": true,
  "data": {
    "score": "4x8",
    "time": "15:16.2342"
  },
  "registration_ids":["4", "8", "15", "16", "23", "42"]
}
 */
public final class JSONContent implements Serializable {

  @JsonProperty(value="collapse_key")
  private String collapseKey;
  @JsonProperty(value="time_to_live")
  private int timeToLive;
  @JsonProperty(value="delay_while_idle")
  private boolean delayWhileIdle;
  @JsonProperty(value="data")
  private Map<String, String> data;
  @JsonProperty(value="registration_ids")
  private List<String> registrationIds;

  public JSONContent() {
    data = new HashMap<>();
    registrationIds = new ArrayList<>();
  }

  /**
   * Create JSON Content with mandatory params.
   * @param collapseKey
   * @param timeToLive
   * @param delayWhileIdle
   * @return JSON Payload
   */
  public static JSONContent of(final String collapseKey, final int timeToLive, final boolean delayWhileIdle) {
    final JSONContent myObj = new JSONContent();
    myObj.collapseKey = collapseKey;
    myObj.timeToLive = timeToLive;
    myObj.delayWhileIdle = delayWhileIdle;
    return myObj;
  }

  /**
   * Add registration-id to the payload
   * @param registrationId id
   * @return JSON Payload
   */
  public JSONContent withRegistrationId(final String registrationId) {
    registrationIds.add(registrationId);
    return this;
  }

  /**
   * Add custom key, values to the payload
   * @param key key
   * @param value value
   * @return JSON Payload
   */
  public JSONContent withData(final String key, final String value) {
    data.put(key, value);
    return this;
  }

  public int getTimeToLive() {
    return timeToLive;
  }

  public boolean isDelayWhileIdle() {
    return delayWhileIdle;
  }

  public Map<String, String> getData() {
    return data;
  }

  public List<String> getRegistrationIds() {
    return registrationIds;
  }

  public String getCollapseKey() {
    return collapseKey;
  }
}

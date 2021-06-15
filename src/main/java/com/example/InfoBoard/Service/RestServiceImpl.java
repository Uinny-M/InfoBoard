package com.example.InfoBoard.Service;

import com.example.InfoBoard.dto.EventDTO;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.inject.Named;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Named
public class RestServiceImpl implements RestService{
    @Override
    public List<EventDTO> getEvents() {
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(IOUtils.toString(new URL("http://localhost:8080/T_school_war_exploded/rest/events"), Charset.forName("UTF-8")));
        } catch (IOException e){
            e.printStackTrace();
        }
        Gson gson = new Gson();
        List<EventDTO>eventDTOList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject eventJson = jsonArray.getJSONObject(i);
            EventDTO eventDTO = gson.fromJson(eventJson.toString(), EventDTO.class);
            eventDTOList.add(eventDTO);
        }
        return eventDTOList;
    }
}

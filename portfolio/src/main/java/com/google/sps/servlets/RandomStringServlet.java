package com.google.sps.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /randomstring URL. Try running a server and navigating to /randomstring */
@WebServlet("/randomstring")
public class RandomStringServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    String[] quotes = {
      "\"Be yourself; everyone else is already taken.\"",
      "\"You only live once, but if you do it right, once is enough.\"",
      "\"Be the change that you wish to see in the world.\"",
      "\"In three words I can sum up everything I've learned about life: it goes on.\"",
      "\"To hold, you must first open your hand. Let go.\"",
      "\"Do what you can, with what you have, where you are.\""
    };

    String json = convertToJsonUsingGson(quotes);

    // Send the JSON as the response
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }

  private String convertToJsonUsingGson(String[] quotes) {
    Gson gson = new Gson();
    String json = gson.toJson(quotes);
    return json;
  }
}

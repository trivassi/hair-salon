import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.sql.Date;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

  get("/", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("stylists", Stylist.all());
    model.put("template", "templates/index.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/stylist/:id/clients", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    Stylist stylist = Stylist.find(Integer.parseInt(request.params("id")));
    model.put("stylist", stylist);
    model.put("clients", stylist.getClients());
    model.put("template", "templates/stylist.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/stylist/:stylistId/client/:id", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    Client client = Client.find(Integer.parseInt(request.params(":id")));
    model.put("client", client);
    model.put("template", "templates/client.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/stylist/:id/edit", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
    model.put("stylist", stylist);
    model.put("template", "templates/stylist-edit.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/stylist/:stylistId/client/:id/edit", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    Client client = Client.find(Integer.parseInt(request.params(":id")));
    model.put("client", client);
    model.put("template", "templates/client-edit.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/stylists/new", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    String name = request.queryParams("name");
    int age = Integer.parseInt(request.queryParams("age"));
    String email = request.queryParams("email");
    String phone = request.queryParams("phone");
    Stylist newStylist = new Stylist(name, age, email, phone);
    newStylist.save();
    model.put("stylists", Stylist.all());
    model.put("template", "templates/index.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/clients/new", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    String name = request.queryParams("name");
    int age = Integer.parseInt(request.queryParams("age"));
    String email = request.queryParams("email");
    String phone = request.queryParams("phone");
    Date appointment = Date.valueOf(request.queryParams("appointment"));
    int stylistId = Integer.parseInt(request.queryParams("stylistId"));
    Client newClient = new Client(name, age, email, phone, appointment, stylistId);

    newClient.save();
    model.put("stylists", Stylist.all());
    model.put("template", "templates/index.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/stylist/:id/edited", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
    model.put("stylist", stylist);
    stylist.updateName(request.queryParams("name"));
    stylist.updateAge(Integer.parseInt(request.queryParams("age")));
    stylist.updateEmail(request.queryParams("email"));
    stylist.updatePhone(request.queryParams("phone"));
    model.put("template", "templates/stylist.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/stylist/:id/deleted", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
    stylist.delete();
    model.put("stylists", Stylist.all());
    model.put("template", "templates/index.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/stylist/:stylistId/client/:id/edited", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    Client client = Client.find(Integer.parseInt(request.params(":id")));
    model.put("client", client);
    client.updateName(request.queryParams("name"));
    client.updateAge(Integer.parseInt(request.queryParams("age")));
    client.updateEmail(request.queryParams("email"));
    client.updatePhone(request.queryParams("phone"));
    model.put("template", "templates/client.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/stylist/:stylistId/client/:id/deleted", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    Client client = Client.find(Integer.parseInt(request.params(":id")));
    Stylist stylist = Stylist.find(client.getStylistId());
    client.delete();
    model.put("stylist", stylist);
    model.put("template", "templates/stylist.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

}

}

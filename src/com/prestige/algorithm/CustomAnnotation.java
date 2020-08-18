package com.prestige.algorithm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by prest on 10/11/2019.
 */
public class CustomAnnotation {

    public static void main(String[] args) {

        Employee employee = new Employee(9898, "Peter", 21);
        JsonSerializer jsonSerializer = new JsonSerializer();
        try {
            String json = jsonSerializer.serializeObject(employee);
            System.out.println("Json : " + json);
        } catch (JsonSerializerException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {

    String value() default "";
}

class JsonSerializer {

    public String serializeObject(Object object) throws JsonSerializerException, IllegalAccessException {

        if(Objects.isNull(object)){
            throw new JsonSerializerException("Object is null");
        }

        Map<String, Object> elements = new HashMap();

        Class<?> objClass = object.getClass();

        for(Field field : objClass.getDeclaredFields()){

            if(field.isAnnotationPresent(JsonField.class)){
                field.setAccessible(true);
                elements.put(getSerializedKey(field), field.get(object));
            }
        }

        return convertToJson(elements);
    }


    private String getSerializedKey(Field field){

        JsonField jsonField = field.getAnnotation(JsonField.class);
        if(jsonField.value().isEmpty()){
            return field.getName();
        }else{

            return jsonField.value();
        }
    }

    private String convertToJson(Map<String, Object> map){

        StringBuilder json = new StringBuilder("");
        map.keySet().stream().forEach(k -> {
            if(json.toString().isEmpty()){
                json.append(String.format("{ %s : %s", k , map.get(k)));
            }else{
                json.append(String.format(", %s : %s", k , map.get(k)));
            }
        });
        json.append("}");

        return json.toString();
    }


}

class JsonSerializerException extends Exception{

    public JsonSerializerException(String message) {
        super(message);
    }
}

class Employee {

    @JsonField("employeeId")
    private long empId;
    @JsonField("employeeName")
    private String name;
    @JsonField(value = "employeeAge")
    private int age;

    public Employee(long empId, String name, int age) {
        this.empId = empId;
        this.name = name;
        this.age = age;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

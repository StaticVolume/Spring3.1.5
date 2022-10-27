package ru.Yamy;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        Cookie cookie = new Cookie();
        Consumer consumer = new Consumer(new RestTemplate());
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();

         ResponseEntity<String> getResponse = consumer.getRestTemplate().getForEntity(consumer.getGetPostPutUrl(), String.class);
         System.out.println(getResponse.getHeaders());


         cookie.setName("Cookie");
         cookie.setId(getResponse.getHeaders().get("Set-Cookie").stream().toList().get(0).trim().split(";")[0]);
         headers.set(cookie.getName(), cookie.getId());

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        User postUser = new User(3L, "James", "Brown", (byte) 35);

        HttpEntity<User> postHttpEntity = new HttpEntity<>(postUser,headers);
        ResponseEntity<String> postResponse = consumer.getRestTemplate().exchange(consumer.getGetPostPutUrl(),HttpMethod.POST,postHttpEntity,String.class);
        consumer.setPostResponse(postResponse.getBody());
        System.out.println(postResponse);

        postUser.setName("Thomas");
        postUser.setLastName("Shelby");
        ResponseEntity<String> putResponse = consumer.getRestTemplate().exchange(consumer.getGetPostPutUrl(), HttpMethod.PUT, postHttpEntity,String.class);
        consumer.setPutResponse(putResponse.getBody());
        System.out.println(putResponse);


        ResponseEntity<String> deleteResponse = consumer.getRestTemplate().exchange(consumer.getGetPostPutUrl() + "/" + postUser.getId(), HttpMethod.DELETE, postHttpEntity,String.class);
        consumer.setDeleteResponse(deleteResponse.getBody());
        System.out.println(deleteResponse);


         System.out.println(consumer.getPostResponse() + consumer.getPutResponse() + consumer.getDeleteResponse());
    }
}

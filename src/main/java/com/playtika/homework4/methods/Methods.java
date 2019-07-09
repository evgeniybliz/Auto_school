package com.playtika.homework4.methods;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.playtika.homework4.models.CreatedNote;
import com.playtika.homework4.models.CreatedUser;
import com.playtika.homework4.models.Note;
import com.playtika.homework4.models.Token;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Methods {

    private static Scanner sc = new Scanner(System.in);
    private static ObjectMapper mapper = new ObjectMapper();

    public static CreatedUser createUser() throws IOException {
        System.out.println("Введите e-mail");
        String email = sc.nextLine();
        System.out.println("\nВведите пароль");
        String password = sc.nextLine();
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("https://taschool-notes-service.herokuapp.com/v1/accounts");
            httpPost.setHeader("Content-Type", "application/json");
            ObjectNode node = mapper.createObjectNode();
            node.put("email", email);
            node.put("password", password);
            String JSON_STRING = node.toString();
            httpPost.setEntity(new StringEntity(JSON_STRING, ContentType.APPLICATION_JSON));
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String stringEntity = EntityUtils.toString(entity);
            CreatedUser createdUser = mapper.readValue(stringEntity, CreatedUser.class);
            System.out.println("\nПользователь: " + "'" + createdUser.getEmail() + "'" + " с ID " + "'" + createdUser.getId() + "'" + " успешно создан");
            return createdUser;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели некорректное значение. Попробуйте еще раз.");
            return createUser();
        }
        throw new IllegalArgumentException("Что-то пошло не так при создании пользователя");
    }

    public static Token getToken(CreatedUser createdUser) throws IOException {
        System.out.println("\nДля авторизации введите пароль для пользователя: " + createdUser.getEmail());
        String password = sc.nextLine();
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("https://taschool-notes-service.herokuapp.com/oauth/token");
            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
            httpPost.setHeader("Authorization", "Basic Y2xpZW50OnNlY3JldA==");
            List params = new ArrayList<>();
            params.add(new BasicNameValuePair("grant_type", "password"));
            params.add(new BasicNameValuePair("username", createdUser.getEmail()));
            params.add(new BasicNameValuePair("password", password));
            httpPost.setEntity(new UrlEncodedFormEntity((params), "UTF-8"));
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String stringEntity = EntityUtils.toString(entity);
            Token token = mapper.readValue(stringEntity, Token.class);
            String status = String.valueOf(response.getStatusLine());
            if (status.equals("HTTP/1.1 200 ")) {
                System.out.println("Пользователь успешно авторизован");
            } else {
                System.out.println("Не удалось авторизовать пользователя");
                System.out.println(stringEntity);
            }
            return token;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("Что-то пошло не так при авторизации пользователя");
    }

    public static void CreateNote(Token token) throws IOException {
        int countOfNotes = 2;
        for (int i = 1; i <= countOfNotes; i++) {
            System.out.println("\nВведите текст заметки № " + i);
            String noteBody = sc.nextLine();
            try {
                CloseableHttpClient httpClient = HttpClients.createDefault();
                HttpPost httpPost = new HttpPost("https://taschool-notes-service.herokuapp.com/v1/notes");
                httpPost.setHeader("Content-Type", "application/json");
                httpPost.setHeader("authorization", "Bearer" + token.getAccess_token());
                ObjectNode node = mapper.createObjectNode();
                node.put("content", noteBody);
                String JSON_STRING = node.toString();
                httpPost.setEntity(new StringEntity(JSON_STRING, ContentType.APPLICATION_JSON));
                HttpResponse response = httpClient.execute(httpPost);
                HttpEntity entity = response.getEntity();
                String stringEntity = EntityUtils.toString(entity);
                CreatedNote createdNote = mapper.readValue(stringEntity, CreatedNote.class);
                System.out.println("Заметка № " + i + " успешно создана." + "Id заметки: " + createdNote.getId() + ". Текст заметки: " + createdNote.getContent());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void getAllNotes(Token token) throws IOException {
        System.out.println("\nСписок всех заметок:");
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("https://taschool-notes-service.herokuapp.com/v1/notes");
            httpGet.setHeader("authorization", "Bearer" + token.getAccess_token());
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String stringEntity = EntityUtils.toString(entity);
            Note[] notes = mapper.readValue(stringEntity, Note[].class);
            System.out.println(notes[0].toString());
            System.out.println(notes[1].toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getNoteById(Token token) throws IOException {
        System.out.println("\nВведите ID заметки из числа возвращенных в предыдущем методе:  ");
        Integer idOfNotes = sc.nextInt();
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("https://taschool-notes-service.herokuapp.com/v1/notes/" + idOfNotes);
            httpGet.setHeader("authorization", "Bearer" + token.getAccess_token());
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String stringEntity = EntityUtils.toString(entity);
            CreatedNote note = mapper.readValue(stringEntity, CreatedNote.class);
            System.out.println("Id: " + note.getId() + ". Содержимое: " + note.getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateNoteByID(Token token) throws IOException {
        System.out.println("\nВведите ID заметки которую необходимо изменить:  ");
        Integer idOfNotesForUpdate = sc.nextInt();
        System.out.println("\nВведите текст:  ");
        Scanner scan = new Scanner(System.in);
        String value = scan.nextLine();
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPut httpPut = new HttpPut("https://taschool-notes-service.herokuapp.com/v1/notes/" + idOfNotesForUpdate);
            httpPut.setHeader("authorization", "Bearer" + token.getAccess_token());
            ObjectNode node = mapper.createObjectNode();
            node.put("content", value);
            String JSON_STRING = node.toString();
            httpPut.setEntity(new StringEntity(JSON_STRING, ContentType.APPLICATION_JSON));
            HttpResponse response = httpClient.execute(httpPut);
            HttpEntity entity = response.getEntity();
            String stringEntity = EntityUtils.toString(entity);
            CreatedNote updatedNote = mapper.readValue(stringEntity, CreatedNote.class);
            String status = String.valueOf(response.getStatusLine());
            if (status.equals("HTTP/1.1 200 ")) {
                System.out.println("Заметка успешно обновлена. " + "Новое содержимое: " + updatedNote.getContent());
            } else {
                System.out.println("Не удалось изменить заметку");
                System.out.println(stringEntity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteNoteById(Token token) throws IOException {
        System.out.println("\nВведите ID заметки которую необходимо удалить:  ");
        Integer idOfNotesForDelete = sc.nextInt();
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpDelete httpDelete = new HttpDelete("https://taschool-notes-service.herokuapp.com/v1/notes/" + idOfNotesForDelete);
            httpDelete.setHeader("authorization", "Bearer" + token.getAccess_token());
            HttpResponse response = httpClient.execute(httpDelete);
            HttpEntity entity = response.getEntity();
            String status = String.valueOf(response.getStatusLine());
            if (status.equals("HTTP/1.1 204 ")) {
                System.out.println("Заметка успешно удалена");
            } else {
                String stringEntity = EntityUtils.toString(entity);
                System.out.println("Не удалось удалить заметку");
                System.out.println(stringEntity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
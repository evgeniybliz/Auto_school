package com.playtika.homework4;

import com.playtika.homework4.models.CreatedUser;
import com.playtika.homework4.models.Token;
import com.playtika.homework4.methods.Methods;

import java.io.IOException;

public class Demo {

    public static void main(String[] args) throws IOException {
        CreatedUser createdUser =  Methods.createUser();
        Token token = Methods.getToken(createdUser);
        Methods.CreateNote(token);
        Methods.getAllNotes(token);
        Methods.getNoteById(token);
        Methods.updateNoteByID(token);
        Methods.deleteNoteById(token);
    }
}
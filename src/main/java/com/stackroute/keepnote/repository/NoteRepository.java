package com.stackroute.keepnote.repository;

import com.stackroute.keepnote.model.Note;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * This class contains the code for data storage interactions and methods
 * of this class will be used by other parts of the applications such
 * as Controllers and Test Cases
 * */

public class NoteRepository {

    /* Declare a variable called "list" to store all the notes. */
    List<Note> list;

    public NoteRepository() {

        /* Initialize the variable using proper data type */
        list = new ArrayList<>();
    }

    /* This method should return all the notes in the list */

    public List<Note> getList() {
        return list;
    }

    /* This method should set the list variable with new list of notes */

    public void setList(List<Note> list) {
        this.list = new ArrayList<>(list);
    }

    /*
     * This method should Note object as argument and add the new note object into
     * list
     */

    public void addNote(Note note) {

        if(list.contains(note)) {
            exists(note.getNoteId());
        }

        list.add(note);
    }

    /* This method should deleted a specified note from the list */

    public boolean deleteNote(int noteId) {

        /* Use list iterator to find matching note id and remove it from the list */
        Iterator it = list.iterator();
        Note note;

        while (it.hasNext()) {
            note = (Note) it.next();

            if (note.getNoteId() == noteId) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    /* This method should return the list of notes */

    public List<Note> getAllNotes() {
        return this.list;
    }

    /*
     * This method should check if the matching note id present in the list or not.
     * Return true if note id exists in the list or return false if note id does not
     * exists in the list
     */

    public boolean exists(int noteId) {
        for (Note iterator : list) {
            if (iterator.getNoteId() == (noteId)) {
                return true;
            }
        }
        return false;


    }
}
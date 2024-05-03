package org.howard.edu.lsp.oopfinal.question1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class SongsDatabaseTest {
    private SongsDatabase db;

    @Before
    public void setUp() {
        db = new SongsDatabase();
        db.addSong("Rap", "Savage");
        db.addSong("Rap", "Gin and Juice");
        db.addSong("Country", "Sweet Alabama");
        db.addSong("Jazz", "Always There");
    }

    @Test
    public void testAddNullSong() {
        db.addSong("Pop", null);
        assertTrue("Null song should not be added", db.getSongs("Pop").isEmpty());
    }

    @Test
    public void testAddSongWithNullGenre() {
        db.addSong(null, "Hello");
        assertNull("Songs under null genre should not be accessible", db.getSongs(null));
    }

    @Test
    public void testAddEmptyStringSong() {
        db.addSong("Pop", "");
        assertTrue("Empty string song should not be added", db.getSongs("Pop").isEmpty());
    }

    @Test
    public void testAddDuplicateSong() {
        db.addSong("Rap", "Savage");
        assertEquals("Duplicate songs should not increase the set size", 2, db.getSongs("Rap").size());
    }

    @Test
    public void testMultipleSongsSameGenre() {
        db.addSong("Pop", "Shallow");
        db.addSong("Pop", "Memories");
        Set<String> songs = db.getSongs("Pop");
        assertTrue("Multiple songs should be retrievable from the same genre", songs.contains("Shallow") && songs.contains("Memories"));
    }

    @Test
    public void testGetGenreOfNonExistentSong() {
        assertNull("Should return null for non-existent song", db.getGenreOfSong("NonExistentSong"));
    }

    @Test
    public void testCaseSensitivity() {
        db.addSong("pop", "Shallow");
        assertNotNull("Case sensitivity should be handled, if required", db.getSongs("pop"));
        assertFalse("Case sensitivity should be handled, if required", db.getSongs("Pop").contains("Shallow"));
    }
}

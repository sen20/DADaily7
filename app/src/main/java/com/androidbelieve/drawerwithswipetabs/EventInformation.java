package com.androidbelieve.drawerwithswipetabs;

import java.sql.Time;

public class EventInformation {

    public static String venue;
    public static String InfTitle;
    public static String date;
    public static String eventTime;
    public static String organizer;


    public static String agenda;
    public static String content;
    public static String URL;

    public static String getInfTitle() {
        return InfTitle;
    }

    public static void setInfTitle(String infTitle) {
        InfTitle = infTitle;
    }

    public static String getVenue() {
        return venue;
    }

    public static void setVenue(String venue) {
        EventInformation.venue = venue;
    }

    public static String getDate() {
        return date;
    }

    public static void setDate(String date) {
        EventInformation.date = date;
    }

    public static String getEventTime() {
        return eventTime;
    }

    public static void setEventTime(String eventTime) {
        EventInformation.eventTime = eventTime;
    }

    public static String getOrganizer() {
        return organizer;
    }

    public static void setOrganizer(String organizer) {
        EventInformation.organizer = organizer;
    }

    public static String getAgenda() {
        return agenda;
    }

    public static void setAgenda(String agenda) {
        EventInformation.agenda = agenda;
    }

    public static String getContent() {
        return content;
    }

    public static void setContent(String content) {
        EventInformation.content = content;
    }

    public static String getURL() {
        return URL;
    }

    public static void setURL(String URL) {
        EventInformation.URL = URL;
    }
}

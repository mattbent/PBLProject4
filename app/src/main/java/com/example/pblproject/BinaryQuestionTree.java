package com.example.pblproject;

public class BinaryQuestionTree {

    public static class Node{
        String data;
        Node left;
        Node right;

        Node(String data){
            this.data  = data;
            right = null;
            left = null;
        }

    }

    Node question1;

    private Node addRecursive(Node current, String place, String data) {
        if (place == null) {
            return new Node(data);
        }

        int value = Integer.parseInt(String.valueOf(place.charAt(0)));
        System.out.println("1".charAt(0));
        System.out.println(place.charAt(0));
        System.out.println(value);

        if (value == 1) {
            if (place.length() == 1)
            {
                current.left = addRecursive(current.left, null, data);
            }
            else {
                current.left = addRecursive(current.left, place.substring(1), data);
            }
        } else{
            if (place.length() == 1)
            {
                current.right = addRecursive(current.right, null, data);
            }
            else {
                current.right = addRecursive(current.right, place.substring(1), data);
            }

        }

        return current;
    }

    public void add(String value, String data) {
        question1 = addRecursive(question1, value, data);
    }

    public static BinaryQuestionTree createBinaryTree() {
        BinaryQuestionTree bt = new BinaryQuestionTree();

        bt.add(null, "Do you feel comfortable speaking " +
                "in front of an audience?");

        bt.add("1", "Would you like to work on a project or report that showcases your " +
                "business or technical knowledge");

        bt.add("11", "Are you interested in an event related to computer science" );

        bt.add("111","Computer Animation,Mobile App Development,Network Design,Website Design");

        bt.add("110","Business Presentation,Community Service Project,Forensic Accounting," +
                "Global Analysis and Decision Making,Integrated Marketing Campaign,Sales Presentation" +
                "Small Business Management Plan,Social Media Challenge");

        bt.add("10","Would you like to work as part of a team?");

        bt.add("101","Are you interested in an event related to accounting or finance?");

        bt.add("1011","Financial Analysis,Financial Services,Accounting Analysis");

        bt.add("1010","Business Ethics,Business Sustainability,Emerging Business" +
                " Issues,Business Law,Hospitality Management,Human Resource Management," +
                "Management Analysis and Decision Making, Marketing Analysis and Decision making," +
                "Parliamentary Procedure,Strategic Analysis and Decision making");
        bt.add("100","Impromptu Speaking,Public Speaking,Future Business Executive,Job " +
                "Interview,Client Service,Help Desk");
        //Right Side
        bt.add("0","Would you like to work on a report that showcases your business knowledge");
        bt.add("01","Local Chapter Annual, Business Report");
        bt.add("00","Do you understand and enjoy using Technology");
        bt.add("001","Would you like to work as part of a team");
        bt.add("0010","Administrative Technology,Computer Applications," +
                "Computer Concepts,Cyber Security,Information Management,Networking Concepts," +
                " Programming Concepts");

        bt.add("0011","Desktop Publishing");
        bt.add("000","Would you like to work on a competitive even related to finance");
        bt.add("0000","Business Communication,Contemporary Sports Issues,Justice " +
                "Administration,Management Concepts,Marketing Concepts," +
                "Organizational Behavior & Leadership, Personal Finance, Project Management, " +
                "Retail Management, Sports Management & Marketing, Statistical Analysis");
        bt.add("0001","Accounting for Professionals, Accounting Principles, " +
                "Cost Accounting,Entrepreneurship Concepts,Financial Concepts,Macroeconomics," +
                "Microeconomics");


        return bt;
    }

    public Node getQuestion1() {
        return question1;
    }

    public Node getYes(Node node){
        return node.left;
    }

    public Node getNo(Node node){
        return node.right;
    }

    public String getData(Node node){
        return  node.data;
    }

}

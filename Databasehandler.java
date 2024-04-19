package com.mycompany.javaproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler {
    private final String url = "jdbc:mysql://localhost:3306/library";
    private final String user = "your_username";
    private final String password = "your_password";

    public void writeToDatabase(Member member) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO members (memberType, memberID, name, fees, club, membershipPoints) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(member.getMemberType()));
            statement.setInt(2, member.getMemberID());
            statement.setString(3, member.getName());
            statement.setDouble(4, member.getFees());

            if (member instanceof SingleClubMember) {
                statement.setInt(5, ((SingleClubMember) member).getClub());
                statement.setNull(6, java.sql.Types.INTEGER);
            } else {
                statement.setNull(5, java.sql.Types.INTEGER);
                statement.setInt(6, ((MultiClubMember) member).getMembershipPoints());
            }

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeFromDatabase(int memberID) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "DELETE FROM members WHERE memberID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, memberID);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}package javaproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler {
    private final String url = "jdbc:mysql://localhost:3306/library";
    private final String user = "your_username";
    private final String password = "your_password";

    public void writeToDatabase(Member member) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO members (memberType, memberID, name, fees, club, membershipPoints) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(member.getMemberType()));
            statement.setInt(2, member.getMemberID());
            statement.setString(3, member.getName());
            statement.setDouble(4, member.getFees());

            if (member instanceof SingleClubMember) {
                statement.setInt(5, ((SingleClubMember) member).getClub());
                statement.setNull(6, java.sql.Types.INTEGER);
            } else {
                statement.setNull(5, java.sql.Types.INTEGER);
                statement.setInt(6, ((MultiClubMember) member).getMembershipPoints());
            }

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeFromDatabase(int memberID) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "DELETE FROM members WHERE memberID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, memberID);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
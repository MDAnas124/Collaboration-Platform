<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CoLab - Collaborative Development Platform</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Montserrat', sans-serif;
        }

        body {
            background-color: #2b2d42;
            background: linear-gradient(to right, #e2e2e2, #c9d6ff);
            display: flex;
            align-items: center;
            justify-content: center;
            flex-direction: column;
            min-height: 100vh;
            margin: 0;
            padding: 0;
        }

        .header {
            width: 100%;
            background-color: #333;
            color: #fff;
            padding: 10px 20px;
            text-align: center;
            position: fixed;
            top: 0;
            left: 0;
            display: flex;
            justify-content: space-between;
            align-items: center;
            z-index: 1000;
        }

        .header h1 {
            font-size: 1.5rem;
            font-weight: bold;
        }

        .header .logout-button {
            background-color: #512da8;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 8px;
            font-size: 1rem;
            cursor: pointer;
            text-decoration: none;
        }

        .header .logout-button:hover {
            background-color: #1e88e5;
        }

        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-wrap: wrap;
            gap: 20px;
            max-width: 1200px;
            margin-top: 80px; /* Adjusted margin to accommodate fixed header */
        }

        .card {
            background-color: #2b2d42; /* Same color for both cards */
            color: #fff;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.35);
            padding: 20px;
            width: 300px;
            max-width: 90%;
        }

        .card h2 {
            font-size: 1.5rem;
            font-weight: bold;
            margin-bottom: 10px;
            color: #fff;
        }

        .card p {
            font-size: 1rem;
            line-height: 1.5;
            color: #ccc;
        }

        .card-button {
            background-color: #512da8;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 8px;
            font-size: 1rem;
            cursor: pointer;
            margin-top: 10px;
            display: block;
            width: 100%;
            text-align: center;
            text-decoration: none;
        }

        .card-button:hover {
            background-color: #1e88e5;
        }

        /* Sidebar Styles */
        .sidebar {
            position: fixed;
            left: 0;
            top: 80px; /* Matched with margin-top of .container */
            height: calc(100vh - 80px);
            width: 200px;
            background-color: #333;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: flex-start;
            z-index: 999;
        }

        .sidebar h2 {
            color: #fff;
            font-size: 1.5rem;
            margin-bottom: 20px;
            text-align: center;
        }

        input[type="text"] {
            padding: 10px;
            border-radius: 5px;
            border: none;
            width: 60%;
            margin-bottom: 20px;
            font-size: 1rem;
        }

        .sidebar a {
            color: #fff;
            text-decoration: none;
            font-size: 1rem;
            margin-bottom: 10px;
            width: 100%;
            display: block;
            padding: 10px 0;
            text-align: center;
        }

        .sidebar a:hover {
            background-color: #1e88e5;
        }

        .sidebar-button {
            background-color: #512da8;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 8px;
            font-size: 1rem;
            cursor: pointer;
            margin-top: 20px;
            width: 100%;
            display: block;
            text-align: center;
            text-decoration: none;
        }

        .sidebar-button:hover {
            background-color: #1e88e5;
        }
    </style>
</head>

<body>
    <header class="header">
        <h1>PROJNEST </h1>
        <a href="proj.jsp" class="logout-button">Logout</a>
    </header>

    <div class="sidebar">
        <h2>PROJNEST</h2>
        <a href="newjsp.jsp">Home</a>
        <a href="profilev.jsp">Profile</a>
        <a href="explore.jsp">Explore Projects</a>
        <a href="post.jsp">Post Project</a>
        <a href="joinedproject.jsp">Enlisted Project</a>
        <a href="notifications.jsp">Notifications</a>
        <a href="settings.jsp" class="sidebar-button">Settings</a>
    </div>

    <div class="container">
        <div class="card">
            <h2>Are you a Developer?</h2>
            <p>Join projects, collaborate with teams, and build innovative software solutions.</p>
            <a href="exploreD.jsp" class="card-button">Explore Projects</a>
        </div>
        <div class="card">
            <h2>Are you a Student?</h2>
            <p>Join hackathons, learn new skills, and team up with peers to solve challenges.</p>
            <a href="explore.jsp" class="card-button">Join Hackathons</a>
        </div>
    </div>
</body>

</html>

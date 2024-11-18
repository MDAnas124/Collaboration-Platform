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

        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-wrap: wrap;
            gap: 20px;
            max-width: 1200px;
            margin-top: 20px;
        }

        .card {
            background-color: #fff;
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
            color: #333;
        }

        .card p {
            font-size: 1rem;
            line-height: 1.5;
            color: #555;
        }

        .card-button {
            background-color: #2b2d42;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 8px;
            font-size: 1rem;
            cursor: pointer;
            margin-top: 10px;
        }

        .card-button:hover {
            background-color: #512da8;
        }

        .developer-card {
            background-color: #fc5185;
            background-image: linear-gradient(to top, #fc5185 0%, #6db7e2 100%);
            color: #fff;
        }

        .student-card {
            background-color: #56ccf2;
            background-image: linear-gradient(225deg, #56ccf2 0%, #2f80ed 100%);
            color: #fff;
        }
    </style>
</head>

<body>
    <h1>Welcome to CoLab - Collaborative Development Platform</h1>
    <div class="container">
        <div class="card developer-card">
            <h2>Are you a Developer?</h2>
            <p>Join projects, collaborate with teams, and build innovative software solutions.</p>
            <button class="card-button">Explore Projects</button>
        </div>
        <div class="card student-card">
            <h2>Are you a Student?</h2>
            <p>Join hackathons, learn new skills, and team up with peers to solve challenges.</p>
            <button class="card-button">Join Hackathons</button>
        </div>
    </div>
</body>

</html>

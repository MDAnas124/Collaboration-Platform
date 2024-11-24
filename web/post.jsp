<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CoLab - Post Project</title>
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

        .form-container {
            background-color: #2b2d42;
            color: #fff;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.35);
            padding: 20px;
            width: 400px;
            max-width: 90%;
        }

        .form-container h2 {
            font-size: 1.5rem;
            font-weight: bold;
            margin-bottom: 20px;
            color: #fff;
            text-align: center;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            color: #ccc;
        }

        .form-group input[type="text"],
        .form-group textarea {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            font-size: 1rem;
        }

        .form-group .member-container {
            margin-bottom: 10px;
            padding: 10px;
            background-color: #3a3f51;
            border-radius: 8px;
        }

        .form-group .member-container label {
            color: #fff;
            display: block;
            margin-bottom: 5px;
        }

        .form-group .member-container input[type="text"] {
            width: calc(70% - 10px);
            margin-right: 10px;
        }

        .form-group .member-container .remove-member {
            background-color: #ff4d4d;
            color: #fff;
            border: none;
            padding: 5px 10px;
            border-radius: 5px;
            font-size: 0.9rem;
            cursor: pointer;
        }

        .form-group .member-container .remove-member:hover {
            background-color: #ff1a1a;
        }

        .form-button {
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

        .form-button:hover {
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
        <h1>PROJNEST</h1>
        <a href="proj.jsp" class="logout-button">Logout</a>
    </header>

    <div class="sidebar">
        <a href="post.jsp">Post Project</a>
        <a href="project_history.jsp">Projects History</a>
        <a href="newjsp.jsp">Dashboard</a>
    </div>

    <div class="container">
        <div class="form-container">
            <h2>Post a New Project</h2>
            <form action="submit_project.jsp" method="post">
                <div class="form-group">
                    <label for="projectTitle">Project Title</label>
                    <input type="text" id="projectTitle" name="projectTitle" required>
                </div>
                <div class="form-group">
                    <label for="availableMembers">Available Members</label>
                    <input type="number" id="availableMembers" name="availableMembers" required>
                </div>
                <div class="form-group">
                    <label for="projectDescription">Project Description</label>
                    <textarea id="projectDescription" name="projectDescription" rows="5" required></textarea>
                </div>
                <div class="form-group">
                    <label for="requiredSkills">Required Skills</label>
                    <input type="text" id="requiredSkills" name="requiredSkills" required>
                </div>
                <div class="form-group">
                    <label for="Category">Category</label>
                    <input type="text" id="Category" name="Category" required>
                </div>
                <div class="form-group">
                    <label for="members">Members</label>
                    <div id="members-container">
                        <div class="member-container">
                            <label for="member1Name">Member 1 Name</label>
                            <input type="text" id="member1Name" name="memberNames" required>
                            <label for="member1Skills">Member 1 Skills</label>
                            <input type="text" id="member1Skills" name="memberSkills" required>
                        </div>
                    </div>
                    <button type="button" onclick="addMember()" class="form-button">Add Member</button>
                </div>
                <button type="submit" class="form-button">Submit Project</button>
            </form>
        </div>
    </div>

    <script>
        let memberCount = 1;

        function addMember() {
            memberCount++;
            const container = document.getElementById('members-container');
            const newMemberContainer = document.createElement('div');
            newMemberContainer.classList.add('member-container');
            newMemberContainer.innerHTML = `
                <label for="member${memberCount}Name">Member ${memberCount} Name</label>
                <input type="text" id="member${memberCount}Name" name="memberNames" required>
                <label for="member${memberCount}Skills">Member ${memberCount} Skills</label>
                <input type="text" id="member${memberCount}Skills" name="memberSkills" required>
                <button type="button" class="remove-member" onclick="removeMember(this)">Remove</button>
            `;
            container.appendChild(newMemberContainer);
        }

        function removeMember(button) {
            const container = button.parentElement;
            container.remove();
        }
    </script>

</body>

</html>

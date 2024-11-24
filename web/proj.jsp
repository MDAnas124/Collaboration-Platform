<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CoLab</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap');

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Poppins', sans-serif;
            background-color: whitesmoke;
        }

        .navbar {
            width: 100%;
            position: fixed;
            top: 0;
            background-color: #2b2d42;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 20px;
            transition: 0.5s;
            z-index: 1000;
        }

        .navbar a {
            font-size: 1.5rem;
            color: whitesmoke;
            margin: 0 40px;
            font-weight: 700;
            text-decoration: none;
            transition: 0.4s all ease-in-out;
        }

        .navbar ul {
            display: flex;
            list-style: none;
        }

        .navbar a:hover {
            color: #676791;
        }

        .logo {
            width: 200px;
        }

        .loginsign {
            background-color: transparent;
            border-radius: 20px;
            width: 200px;
            height: 40px;
            display: flex;
            justify-content: center;
            align-items: center;
            /*box-shadow: #373638 2px 1px 2px 0.5pc;*/
        }

        .loginsign a:hover {
            color: #512da8;
        }

        .home {
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            padding-top: 120px;
            text-align: center;
        }

        .home h1 {
            font-size: 4rem;
            margin-bottom: 0px;
        }

        .home h2 {
            font-size: 2.5rem;
            margin-bottom: 2px;
        }

        .home_img {
            width: 100%;
            max-width: 800px;
            height: auto;
            margin-top: 20px;
        }

        .aboutus {
            display: flex;
            flex-direction: column;
            justify-content: flex-start;
            align-items: center;
            min-height: 100vh;
            background-color: rgb(204, 197, 197);
            padding: 100px 20px;
            text-align: center;
        }

        .aboutus h1 {
            font-weight: 1000;
            font-size: 3rem;
            margin-bottom: 20px;
        }

        .aboutus p {
            font-size: 1.5rem;
            max-width: 800px;
            margin-bottom: 20px;
        }

        .card-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
            max-width: 1200px;
        }

        .card {
            background-color: #fff;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            transition: 0.3s;
            border-radius: 20px;
            padding: 20px;
            max-width: 300px;
            text-align: center;
        }

        .card h2 {
            color: #512da8;
            font-size: 1.5rem;
            margin-bottom: 10px;
        }

        .card p {
            color: #333;
            font-size: 1rem;
            text-align: justify;
        }

        .contactus {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            min-height: 50vh;
            background-color: whitesmoke;
            padding: 40px 20px;
        }

        .contactus h1 {
            font-size: 3rem;
            font-weight: 1000;
            margin-bottom: 20px;
        }

        .contactus p {
            font-size: 1.5rem;
            text-align: center;
            margin-bottom: 20px;
        }

        .contact-info {
            text-align: center;
        }

        .contact-info p {
            font-size: 1.5rem;
            margin-bottom: 10px;
        }

        .contact-info span {
            font-weight: bold;
        }

        span {
            color: #512da8;
        }
        
            h3{
             background-color: transparent;
            border-radius: 20px;
            width: 200px;
            height: 40px;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        

        @media (max-width: 768px) {
            .navbar a {
                font-size: 1.2rem;
                margin: 0 20px;
            }

            .home h1 {
                font-size: 2.5rem;
            }

            .home h2 {
                font-size: 2rem;
            }

            .aboutus h1 {
                font-size: 2.5rem;
            }

            .aboutus p {
                font-size: 1.2rem;
            }

            .contactus h1 {
                font-size: 2.5rem;
            }

            .contactus p {
                font-size: 1.2rem;
            }

            .card {
                max-width: 90%;
            }
            
        }
    </style>
</head>
<body>
    <header>
        <nav class="navbar" id="navbar">
            <h3>PROJNEST</h3>
            <ul>
                <li class="loginsign"><a href="analyze.jsp">analysis</a></li>
                <li class="loginsign"><a href="login.jsp">Login/SignUp</a></li>
            </ul>
        </nav>
    </header>

    <section id="home" class="home">
        <h1>Hello! <span class="auto-typed"></span></h1>
        <h2>Welcome to PROJNEST!</h2>
        <img class="home_img" src="replace.png" alt="image">
    </section>

    <section id="aboutus" class="aboutus">
        <h1>About Us</h1>
        <p>CoLab is an inclusive web development platform that empowers students, developers, and teams to connect, collaborate, and build software across diverse domains. It fosters a collaborative environment where users can discover projects, showcase expertise, and form effective teams to bring ideas to life.</p>

        <div class="card-container">
            <div class="card">
                <h2>Our Vision</h2>
                <p>At CoLab, we envision a world where everyone, regardless of background or experience, can contribute to groundbreaking projects. We aim to create a space where innovation flourishes and ideas become reality through collective effort.</p>
            </div>
            <div class="card">
                <h2>Community Engagement</h2>
                <p>CoLab believes in the power of community. We host regular hackathons, webinars, and meetups to bring our users together. Our forums and discussion boards provide vibrant spaces to ask questions, share knowledge, and collaborate with peers globally.</p>
            </div>
            <div class="card">
                <h2>Join Us</h2>
                <p>Whether you're a solo developer, a student eager to learn, or a company seeking collaboration, CoLab has something to offer. Join us today and become part of a dynamic community reshaping the future of web development.</p>
            </div>
            <div class="card">
                <h2>Our Commitment</h2>
                <p>We're dedicated to continuous improvement and innovation, valuing your feedback to make CoLab the ultimate platform for collaboration. Let's work together to create tools and features that meet your needs perfectly.</p>
            </div>
        </div>
    </section>

    <section class="contactus">
        <h1>Contact Us</h1>
        <p>If you have any questions or need support, feel free to reach out to us:</p>
        <div class="contact-info">
            <p>Phone Number: <span>29727507535</span></p>
            <p>Email: <span>info@colab.com</span></p>
            <p>Address: <span>123 CoLab Street, City, Country</span></p>
        </div>
    </section>

    <script src="https://unpkg.com/typed.js@2.1.0/dist/typed.umd.js"></script>
    <script>
        var typed = new Typed(".auto-typed", {
            strings: ["Developer", "Student"],
            typeSpeed: 200,
            backSpeed: 70,
            loop: true
        });
    </script>
    <script src="https://unpkg.com/scrollreveal"></script>
    <script>
        const scrollRevealOption = {
            distance: "50px",
            origin: "bottom",
            duration: 1000,
        };

        ScrollReveal().reveal(".home_img", {
            ...scrollRevealOption,
            delay: 200,
        });

        ScrollReveal().reveal(".home h1", {
            ...scrollRevealOption,
            delay: 400,
        });

        ScrollReveal().reveal(".home h2", {
            ...scrollRevealOption,
            delay: 600,
        });

        ScrollReveal().reveal(".aboutus h1", {
            ...scrollRevealOption,
            delay: 100,
        });

        ScrollReveal().reveal(".aboutus p", {
            ...scrollRevealOption,
            delay: 200,
        });

        ScrollReveal().reveal(".card", {
            ...scrollRevealOption,
            delay: 300,
        });

        ScrollReveal().reveal(".contactus h1", {
            ...scrollRevealOption,
            delay: 100,
        });

        ScrollReveal().reveal(".contactus p", {
            ...scrollRevealOption,
            delay: 200,
        });

        ScrollReveal().reveal(".contact-info", {
            ...scrollRevealOption,
            delay: 300,
        });
    </script>
</body>
</html>

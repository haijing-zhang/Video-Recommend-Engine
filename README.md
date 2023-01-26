# Video-Recommend-Engine
A full-stack web application for users to search twitch resources (stream/video/clip) and get recommendations, using React, Spring MVC, MySQL, launched on Amazon EC2.

Video Demo: https://recordit.co/WKnMFFURHq

## Features:
- Authentication: Login, Logout, Register.
- Custom Search: if name matched, customed game would return on the home screen.
- Popular games: Display top popular games on twitch website. 
- Add favorite items: After login, user could add favorite item by clicking star.
- Recommendation: After login, the web could recommend similar items based on the favorite history.


## Frontend:
Frontend codes are stored in "/twitchfe" folder and are implemented with **React** library.

"utils.js" defines helper functions making http requests from client to server using fetch API.

All other UI related components are built with **Ant Design library** (https://ant.design/).

## Backend:

Backend code diagram: https://drive.google.com/file/d/1Ye-WrWurGY4l-7HuWGUJR5SLfExgvuMF/view

Backend codes are stored in "/twitchbe" and use Spring MVC.

- "/controller"
- "/service"
- "/"






## Deployment:

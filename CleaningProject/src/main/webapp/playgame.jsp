 <style>
        *{
            box-sizing: border-box;
        }
        body{
            margin: 0;
            padding: 0;
        }
        .container{
            height: 100vh;
            width: 100%;
            background: #000;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
        }
        .game-board{
            height: 90vmin;
            width: 90vmin;
      background:transparent;
      border:1px solid #ff7220;
            
            display: grid;
            grid-template-columns: repeat(16, 1fr);
            grid-template-rows: repeat(16, 1fr);
        }
        .score{
            background: yellow;
            padding: 10px 20px;
            border-radius: 20px;
        }

        .snake{
            background: #219d00;
            border: 2px solid #000;
            display: flex;
            align-items: center;
            justify-content: center;
            color: #fff;
        }
        .head{
            background: url(snake.png);
            background-size: 100% 100%;
            display: flex;
            align-items: center;
            justify-content: center;
            color: #fff;
            z-index: 22;
        }

        .food{
            background: url(apple.png);
            background-size: 100% 100%;
            z-index: 55;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="score"> Score : <span id="score">0</span></h2>
        <div class="game-board"></div>
    </div>
    <script src="gameScript.js"></script>
</body>
</html>
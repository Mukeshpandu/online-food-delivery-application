<%-- <%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Order Placed</title>
  <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
  <style>
  body {
    margin: 0;
    font-family: 'Segoe UI', sans-serif;
    background-color: #f0f9ff;
    height: 100vh;
    overflow: hidden;
    position: relative;
  }

  .confetti {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    z-index: 0;
    pointer-events: none;
  }

  .main-wrapper {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 50px;
    z-index: 2;
    animation: moveToTopRight 2.5s ease-out 2s forwards;
  }

  @keyframes moveToTopRight {
    0% {
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
    }
    100% {
      top: 20px;
      left: 80%;
      transform: translate(-50%, 0);
    }
  }

  .delivery-animation {
    max-width: 300px;
    flex-shrink: 0;
  }

  .main-wrapper {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%) scale(1);
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 30px;
  z-index: 2;
  animation: moveToTopRight 3s ease-out 2s forwards;
  transform-origin: center center;
}

@keyframes moveToTopRight {
  0% {
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%) scale(1);
  }
  100% {
    top: 20px;
    left: auto;
    right: 20px;
    transform: scale(0.5);
  }
}
  
  .container {
  width: 400px;
  height: auto;
  padding: 30px;
}
  
  
  

  @keyframes pop-in {
    0% {
      transform: scale(0.6);
      opacity: 0;
    }
    100% {
      transform: scale(1);
      opacity: 1;
    }
  }

  svg.checkmark {
    width: 100px;
    height: 100px;
    margin: 0 auto 20px;
  }

  h2 {
    color: #10b981;
    font-size: 28px;
    margin-bottom: 10px;
  }

  p {
    font-size: 18px;
    color: #333;
  }

  .btn {
    margin-top: 30px;
    padding: 10px 20px;
    font-size: 16px;
    background-color: #3b82f6;
    color: white;
    border: none;
    border-radius: 10px;
    cursor: pointer;
    transition: background 0.3s;
  }

  .btn:hover {
    background-color: #2563eb;
  }

  @media (max-width: 768px) {
    .main-wrapper {
      flex-direction: column;
      gap: 20px;
      top: 50px !important;
      left: 50% !important;
      transform: translateX(-50%) !important;
    }
  }
</style>

</head>
<body>

  <!-- Confetti background animation -->
  <lottie-player class="confetti"
    src="https://assets2.lottiefiles.com/packages/lf20_HpFqiS.json"
    background="transparent"
    speed="1"
    loop
    autoplay>
  </lottie-player>

  <!-- Flex wrapper for both animation and confirmation -->
  <div class="main-wrapper">

    <!-- Delivery animation -->
    <div class="delivery-animation">
      <lottie-player 
        src="https://assets10.lottiefiles.com/private_files/lf30_j2ura6.json" 
        background="transparent" 
        speed="1" 
        style="width: 250px; height: 250px;" 
        loop 
        autoplay>
      </lottie-player>
    </div>

    <!-- Confirmation container -->
    <div class="container">
      <svg class="checkmark" viewBox="0 0 52 52">
        <circle cx="26" cy="26" r="25" fill="none" stroke="#10b981" stroke-width="6" stroke-dasharray="150" stroke-dashoffset="150">
          <animate attributeName="stroke-dashoffset" values="150;0" dur="0.8s" fill="freeze" />
        </circle>
        <path d="M14 27l7 7 17-17" fill="none" stroke="#10b981" stroke-width="6" stroke-dasharray="100" stroke-dashoffset="100">
          <animate attributeName="stroke-dashoffset" values="100;0" dur="0.6s" begin="0.8s" fill="freeze" />
        </path>
      </svg>

      <h2>Order Placed Successfully!</h2>
      <p>Thank you, <strong><%= request.getAttribute("name") %></strong>! 😊</p>
      <p>We'll deliver your order to <strong><%= request.getAttribute("address") %></strong></p>
      <p>📞 Contact: <strong><%= request.getAttribute("mobile") %></strong></p>

      <a href="first">
        <button class="btn">🍽️ Order More</button>
      </a>
    </div>

  </div>

</body>
</html>  --%>










<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Order Confirmed | Yum Delivered</title>
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet">
  <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
  <style>
    body {
      margin: 0;
      padding: 0;
      background: #fff;
      font-family: 'Inter', sans-serif;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      color: #1f2937;
      overflow: hidden;
    }
    .confetti {
      position: fixed;
      top: 0;
      left: 0;
      width: 100vw;
      height: 100vh;
      z-index: 0;
      pointer-events: none;
    }
    .card {
      position: relative;
      text-align: center;
      padding: 40px 30px;
      border-radius: 16px;
      background: #fff;
      box-shadow: 0 8px 20px rgba(0,0,0,0.08);
      max-width: 400px;
      z-index: 2;
      animation: fadeInUp 0.8s ease-out;
    }
    .success-icon {
      background: #22c55e;
      width: 80px;
      height: 80px;
      margin: 0 auto 20px;
      border-radius: 50%;
      display: flex;
      justify-content: center;
      align-items: center;
      animation: bounce 1.2s ease;
    }
    .success-icon svg {
      width: 40px;
      height: 40px;
      color: white;
    }
    h1 {
      font-size: 24px;
      margin-bottom: 10px;
      color: #16a34a;
    }
    p {
      font-size: 16px;
      line-height: 1.5;
      margin-bottom: 10px;
    }
    .btn {
      display: inline-block;
      margin-top: 20px;
      background-color: #ef4444;
      color: white;
      padding: 12px 24px;
      border: none;
      border-radius: 12px;
      font-weight: 600;
      text-decoration: none;
      transition: background 0.3s;
    }
    .btn:hover {
      background-color: #dc2626;
    }

    @keyframes fadeInUp {
      0% { opacity: 0; transform: translateY(40px); }
      100% { opacity: 1; transform: translateY(0); }
    }

    @keyframes bounce {
      0%, 100% { transform: translateY(0); }
      50% { transform: translateY(-10px); }
    }
  </style>
</head>
<body>



<!-- Order Card -->
<div class="card">
  <div class="success-icon">
    <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
      <path d="M20 6L9 17l-5-5"/>
    </svg>
  </div>
  <h1>Order Confirmed!</h1>
  <p>Thanks <strong><%= request.getAttribute("name") %></strong>, your meal is on the move 🚀</p>
  <p>📍 <strong><%= request.getAttribute("address") %></strong></p>
  <p>📞 <strong><%= request.getAttribute("mobile") %></strong></p>
  <a href="first" class="btn">Order More</a>
</div>

</body>
</html>




















var player1 = true;
var id;
var winner = false;
var player;
function game(clicked) {
    if (clicked.innerHTML == "" && winner == false) {
      if( player1 == true) {
        clicked.innerHTML = "X";
        player = "X";
      } 
      else {
        clicked.innerHTML = "O";
        player = "O";
      }

      id = clicked.id;
      player1 = !player1;
      switch (parseInt(id)) {
        case 1:
          if (document.getElementById('2').innerHTML == player && document.getElementById('3').innerHTML == player || document.getElementById('4').innerHTML == player && document.getElementById('7').innerHTML == player || document.getElementById('5').innerHTML == player && document.getElementById('9').innerHTML == player) {
            winner = true;
          }
          break;
        case 2:
          if (document.getElementById('1').innerHTML == player && document.getElementById('3').innerHTML == player || document.getElementById('5').innerHTML == player && document.getElementById('8').innerHTML == player) {
            winner = true;
          }
          break;
        case 3:
          if (document.getElementById('1').innerHTML == player && document.getElementById('2').innerHTML == player || document.getElementById('6').innerHTML == player && document.getElementById('9').innerHTML == player || document.getElementById('5').innerHTML == player && document.getElementById('7').innerHTML == player) {
            winner = true;
          }
          break;
        case 4:
          if (document.getElementById('1').innerHTML == player && document.getElementById('7').innerHTML == player || document.getElementById('5').innerHTML == player && document.getElementById('6').innerHTML == player) {
            winner = true;
          }
          break;
        case 5:
          if (document.getElementById('2').innerHTML == player && document.getElementById('8').innerHTML == player || document.getElementById('4').innerHTML == player && document.getElementById('6').innerHTML == player || document.getElementById('3').innerHTML == player && document.getElementById('7').innerHTML == player || document.getElementById('1').innerHTML == player && document.getElementById('9').innerHTML == player) {
            winner = true;
          }
          break;
        case 6:
          if (document.getElementById('3').innerHTML == player && document.getElementById('9').innerHTML == player || document.getElementById('4').innerHTML == player && document.getElementById('5').innerHTML == player) {
            winner = true;
          }
          break;
        case 7:
          if (document.getElementById('8').innerHTML == player && document.getElementById('9').innerHTML == player || document.getElementById('1').innerHTML == player && document.getElementById('4').innerHTML == player || document.getElementById('3').innerHTML == player && document.getElementById('5').innerHTML == player) {
            winner = true;
          }
          break;
        case 8:
          if (document.getElementById('7').innerHTML == player && document.getElementById('9').innerHTML == player || document.getElementById('2').innerHTML == player && document.getElementById('5').innerHTML == player) {
            winner = true;
          }
          break;
        case 9:
          if (document.getElementById('3').innerHTML == player && document.getElementById('6').innerHTML == player || document.getElementById('7').innerHTML == player && document.getElementById('8').innerHTML == player || document.getElementById('1').innerHTML == player && document.getElementById('5').innerHTML == player) {
            winner = true;
          }
          break;
      
        default:
          break;
      }
      if(winner) {
        document.getElementById('output').innerHTML = !player1 ? 'Joueur 1 (X) à gagner !' : 'Joueur 2 (O) à gagner !';
      } else if (document.getElementById('1').innerHTML != "" && document.getElementById('2').innerHTML != "" && document.getElementById('3').innerHTML != "" && document.getElementById('4').innerHTML != "" && document.getElementById('5').innerHTML != "" && document.getElementById('6').innerHTML != "" && document.getElementById('7').innerHTML != "" && document.getElementById('8').innerHTML != "" && document.getElementById('9').innerHTML != "") {
        document.getElementById('output').innerHTML = 'Match nul !';
      }
    }
}

function reset() {
  document.getElementById('1').innerHTML = "";
  document.getElementById('2').innerHTML = "";
  document.getElementById('3').innerHTML = "";
  document.getElementById('4').innerHTML = "";
  document.getElementById('5').innerHTML = "";
  document.getElementById('6').innerHTML = "";
  document.getElementById('7').innerHTML = "";
  document.getElementById('8').innerHTML = "";
  document.getElementById('9').innerHTML = "";
  document.getElementById('output').innerHTML = "";
  player1 = true;
  winner = false;
}
const chessboard = document.getElementById('chessboard');
        let selectedPiece = null;

        // Initial chessboard setup
        const pieces = [
            "&#9820", "&#9822", "&#9821", "&#9819", "&#9818", "&#9821", "&#9822", "&#9820",
            "&#9823", "&#9823", "&#9823", "&#9823", "&#9823", "&#9823", "&#9823", "&#9823",
            " ", " ", " ", " ", " ", " ", " ", " ",
            " ", " ", " ", " ", " ", " ", " ", " ",
            " ", " ", " ", " ", " ", " ", " ", " ",
            " ", " ", " ", " ", " ", " ", " ", " ",
            "&#9817", "&#9817", "&#9817", "&#9817", "&#9817", "&#9817", "&#9817", "&#9817",
            "&#9814", "&#9816", "&#9815", "&#9813", "&#9812", "&#9815", "&#9816", "&#9814",
        ];

        function renderChessboard() {
            chessboard.innerHTML = "";
            for (let i = 0; i < 64; i++) {
                const square = document.createElement('div');
                square.className = `square ${i % 2 === Math.floor(i / 8) % 2 ? 'white' : 'black'}`;
                square.dataset.index = i;
                square.innerHTML = pieces[i];
                square.addEventListener('click', onSquareClick);
                chessboard.appendChild(square);
            }
        }

   
		
		
function onSquareClick(event) {
    const square = event.target;

    if (selectedPiece === null) {
        if (square.innerHTML !== ' ') {
            selectedPiece = square;
            square.style.boxShadow = 'inset 0 0 0 2px red'; // Add a red inner border
        }
    } else {
        if (square !== selectedPiece) {
           
                square.innerHTML = selectedPiece.innerHTML;
                selectedPiece.innerHTML = ' ';
                selectedPiece.style.boxShadow = 'none'; // Remove the red inner border
		} else {
                selectedPiece.style.boxShadow = 'none'; // Remove the red inner border if no move is made
            }
        
        selectedPiece = null;
    }
}



        renderChessboard();
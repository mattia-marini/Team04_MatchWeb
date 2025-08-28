document.addEventListener('DOMContentLoaded', function () {
    const gifts = [
        "Biglietto per partita della squadra del cuore",
        "Maglia ufficiale di un giocatore della squadra del cuore",
        "Serata in pizzeria insieme alla squadra del cuore"
    ];

    const assignButton = document.getElementById('assignButton');
    const sendButton = document.getElementById('sendButton');
    let assigned = false;

    // Function to assign gifts randomly
    assignButton.addEventListener('click', function () {
        // Get available users (maximum 3)
        const userElements = document.querySelectorAll('.gift-item');
        if (userElements.length === 0) return;

        // Shuffle gifts array to ensure random assignment
        const shuffledGifts = [...gifts].sort(() => 0.5 - Math.random());

        // Assign gifts to users (max 3)
        for (let i = 0; i < Math.min(userElements.length, 3); i++) {
            const giftText = document.getElementById(`gift-text-${i}`);
            const giftBadge = document.getElementById(`gift-badge-${i}`);
            const giftValue = document.getElementById(`gift-value-${i}`);

            if (giftText && giftBadge) {
                giftText.textContent = shuffledGifts[i];
                giftValue.value = shuffledGifts[i];

                giftBadge.textContent = "Assegnato";
                giftBadge.classList.remove("badge-unassigned")
                giftBadge.classList.add("badge-assigned")
            } else {
            }
        }

        // Enable send button after assignment
        sendButton.disabled = false;
    });

});
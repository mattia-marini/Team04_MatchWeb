// Important! This script assumes that both
//      const date
//      const username
//      const contextPath
// are made available through thymleaf template inline script
document.addEventListener('DOMContentLoaded', function () {

    function getDateWithCurrTime(date) {
        const now = new Date();

        const hours = now.getHours().toString().padStart(2, '0');
        const minutes = now.getMinutes().toString().padStart(2, '0');
        const seconds = now.getSeconds().toString().padStart(2, '0');

        const dateTimeString = `${date}T${hours}:${minutes}:${seconds}`;

        return new Date(dateTimeString);
    }


    const form = document.getElementById("bet-form");
    if (!form) return;

    form.addEventListener("submit", function (event) {
        if (!form.checkValidity()) {
            // This triggers the browser's validation UI
            form.reportValidity();
            event.preventDefault(); // stops submission
            return;
        }

        event.preventDefault();
    });


    const button = document.getElementById("submit_bet");
    if (!button) return;
    button.addEventListener('click', function (event) {

        const predictionContainers = document.querySelectorAll('.prediction-options');
        let userPrediction = {};

        let everythingSelected = true
        predictionContainers.forEach(container => {
            const checkedRadio = container.querySelector('input[type="radio"]:checked');
            if (checkedRadio) {
                userPrediction[container.dataset.matchId] = parseInt(checkedRadio.value, 10);
            } else {
                everythingSelected = false
            }
        });
        if (!everythingSelected) {
            return
        }

        const contextPath = document.querySelector('meta[name="context-path"]').content;
        fetch(`${contextPath}api/calendar/results/${date}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error("Could not fetch results");
                }
                return response.json();
            })
            .then(results => {

                let totalScore = 0
                const resultsFlattened = Object.assign({}, ...Object.values(results));
                for (const [matchId, result] of Object.entries(resultsFlattened)) {
                    if (result === userPrediction[matchId]) totalScore += 1;
                }

                const bet = {
                    username: username, score: totalScore, playedAt: getDateWithCurrTime(date).toISOString()
                };


                const token = document.querySelector('meta[name="_csrf"]').getAttribute("content");
                const header = document.querySelector('meta[name="_csrf_header"]').getAttribute("content");
                return fetch(`${contextPath}api/save-bet`, {
                    method: "POST", headers: {
                        "Content-Type": "application/json", [header]: token
                    }, body: JSON.stringify(bet)
                })
                    .then(response => {
                        if (response.redirected) {
                            window.location.href = response.url
                            throw new Error("You should log in");
                        } else if (!response.ok) {
                            throw new Error("Could not save bet to server");
                        }
                        return results
                    })
            }).then(results => {

            const resultsFlattened = Object.assign({}, ...Object.values(results));

            for (const res_col of document.querySelectorAll('.results-column')) {
                res_col.hidden = false
            }

            let totalScore = 0;

            for (const [matchId, result] of Object.entries(resultsFlattened)) {

                let resultText
                if (result === 0) resultText = "Pareggio"; else if (result === 1) resultText = "Casa"; else if (result === 2) resultText = "Ospite";

                let classname = ""

                if (result === userPrediction[matchId]) {
                    classname = "fas fa-check-circle text-success";
                    totalScore += 1;
                } else {
                    classname = "fas fa-times-circle text-danger";
                }

                document.getElementById(`result_col_${matchId}`).hidden = false
                document.getElementById(`result_text_${matchId}`).innerText = resultText
                let resultIcon = document.getElementById(`result_icon_${matchId}`)
                resultIcon.className = classname;


            }

            button.disabled = true;
            document.getElementById("total-score-row").style.opacity = "1"
            document.getElementById('total-score-value').innerText = `${totalScore}/${Object.keys(userPrediction).length}`


        })
            .catch(error => {
                if (error !== "You should log in") {
                    console.error("Fetch error:", error);
                    alert(`Fetch error: ${error}`)
                }
            });
    });
});

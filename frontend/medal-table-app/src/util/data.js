const path = "http://localhost:8080/country";

function processData(parameter) {
    return fetch(`${path}${parameter}`, {
        method: 'GET'
    })
    .then((response) => {
        if (!response.ok) {
            throw new Error("Network answer wasn't ok");
        }
        return response.json();
    });
}

export default processData;
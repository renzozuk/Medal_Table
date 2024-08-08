import React, { useState, useEffect } from 'react';
import Line from "./components/Line.jsx";
import processData from "./util/data.js";
import "./App.css";

function App() {
    /* let countriesPromise = processData(); */

    const [countries, setCountries] = useState([]);
    /* const [index, setIndex] = useState(1); */

    useEffect(() => {
        processData().then((countriesData) => {
            setCountries(countriesData);
        });
    }, []);

    return (
        <div id="page">
            <div className="side-bar"></div>
            <div className="content">
                <div id="header">
                    <h1>Olympic Medal Table</h1>
                </div>
                <div className="sub-header"></div>
                <div className="sub-header">
                    <div className="sub-header sub-header-start">
                        <p className="sub-header-label" id="hashtag-label">#</p>
                        <p className="sub-header-label" id="flag-label">Flag</p>
                        <p className="sub-header-label" id="name-label">Name</p>
                    </div>
                    <div className="sub-header sub-header-end">
                        <img className="single-medal" src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Gold_medal.svg/1024px-Gold_medal.svg.png"></img>
                        <img className="single-medal" src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/03/Silver_medal.svg/1024px-Silver_medal.svg.png"></img>
                        <img className="single-medal" src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Bronze_medal.svg/1024px-Bronze_medal.svg.png"></img>
                        <img className="triple-medal" src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/GoldSilverBronze_medals.svg/1920px-GoldSilverBronze_medals.svg.png"></img>
                    </div>
                </div>
                {countries.map((countryData, index) => (
                    <Line number={index + 1} id={countryData.id} name={countryData.name} flagLink={countryData.photoPath} gold={countryData.goldMedals} silver={countryData.silverMedals} bronze={countryData.bronzeMedals} all={countryData.allMedals} />
                ))}
            </div>
            <div className="side-bar"></div>
        </div>
    );
}

export default App;

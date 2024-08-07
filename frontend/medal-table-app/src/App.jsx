import { useState } from "react";
import Line from "./components/Line.jsx";
import processData from "./util/data.js";
import "./App.css";

function App() {
    let countriesPromise = processData();

    /* countriesPromise.then((countries) => {
        countries.map(countryData => {
            console.log(countryData.id);
        });
    }); */

    return (
        <div id="page">
            <div className="side-bar"></div>
            <div className="content">
                <div id="header">
                    <h1>Olympic Medal Table</h1>
                </div>
                <div style={{ background: "#ffffff", height: "30px" }}></div>
                {countriesPromise.then((countriesData) => {
                    /* let idx = 1; */

                    countriesData.map((countryData) => {
                        <Line number={0} name={countryData.data} flagLink={countryData.photoPath} gold={countryData.goldMedals} silver={countryData.silverMedals} bronze={countryData.bronzeMedals} all={countryData.allMedals} />
                        /* idx++; */
                    });
                })}
                {/* <Line number={1} name={"Brazil"} flagLink={"https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Flag_of_Brazil.svg/1280px-Flag_of_Brazil.svg.png"} gold={999} silver={999} bronze={999} all={999} />
                <Line number={2} name={"United States of America"} flagLink={"https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Flag_of_the_United_States.svg/1920px-Flag_of_the_United_States.svg.png"} gold={999} silver={999} bronze={999} all={999} />
                <Line number={3} name={"Cuba"} flagLink={"https://upload.wikimedia.org/wikipedia/commons/thumb/b/bd/Flag_of_Cuba.svg/1920px-Flag_of_Cuba.svg.png"} gold={0} silver={0} bronze={0} all={0} />
                <Line number={4} name={"People's Republic of China"} flagLink={"https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Flag_of_the_People%27s_Republic_of_China.svg/1920px-Flag_of_the_People%27s_Republic_of_China.svg.png"} gold={0} silver={0} bronze={0} all={0} /> */}
            </div>
            <div className="side-bar"></div>
        </div>
    );
}

export default App;

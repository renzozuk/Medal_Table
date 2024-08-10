import { useEffect, useState } from "react";
import Line from "./components/Line.jsx";
import SequenceButton from "./components/SequenceButton.jsx";
import processData from "./util/data.js";
import "./App.css";

export default function App() {
    const [countries, setCountries] = useState([]);

    useEffect(() => {
        loadData("/gold");
    }, []);

    const loadData = (parameter) => {
        processData(parameter).then((countriesData) => {
            setCountries(countriesData);
        });
    };

    return (
        <div id="page">
            <div className="side-bar side-bar-left"></div>
            <div className="content">
                <div className="header">
                    <p className="header-title">Olympic Medal Table</p>
                </div>
                <div className="sub-header sequence-buttons">
                    <SequenceButton image={false} content={"A-Z"} arrow={true} onClick={() => loadData("")} />
                    <SequenceButton image={false} content={"A-Z"} arrow={false} onClick={() => loadData("/reverse")} />
                    <SequenceButton image={true} content={"https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Gold_medal.svg/1024px-Gold_medal.svg.png"} arrow={true} onClick={() => loadData("/gold")} />
                    <SequenceButton image={true} content={"https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Gold_medal.svg/1024px-Gold_medal.svg.png"} arrow={false} onClick={() => loadData("/gold/reverse")} />
                    <SequenceButton image={true} content={"https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/GoldSilverBronze_medals.svg/1920px-GoldSilverBronze_medals.svg.png"} arrow={true} onClick={() => loadData("/all-medals")} />
                    <SequenceButton image={true} content={"https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/GoldSilverBronze_medals.svg/1920px-GoldSilverBronze_medals.svg.png"} arrow={false} onClick={() => loadData("/all-medals/reverse")} />
                </div>
                <div className="sub-header sub-header-labels">
                    <div className="sub-header sub-header-start">
                        <p className="sub-header-label" id="hashtag-label">
                            #
                        </p>
                        <p className="sub-header-label" id="flag-label">
                            Flag
                        </p>
                        <p className="sub-header-label" id="name-label">
                            Name
                        </p>
                    </div>
                    <div className="sub-header sub-header-end">
                        <img className="single-medal" src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Gold_medal.svg/1024px-Gold_medal.svg.png"></img>
                        <img className="single-medal" src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/03/Silver_medal.svg/1024px-Silver_medal.svg.png"></img>
                        <img className="single-medal" src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Bronze_medal.svg/1024px-Bronze_medal.svg.png"></img>
                        <img className="triple-medal" src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/GoldSilverBronze_medals.svg/1920px-GoldSilverBronze_medals.svg.png"></img>
                    </div>
                </div>
                {countries.map((countryData, index) => (
                    <Line key={countryData.id} number={index + 1} name={countryData.name} flagLink={countryData.photoPath} gold={countryData.goldMedals} silver={countryData.silverMedals} bronze={countryData.bronzeMedals} all={countryData.allMedals} id={countryData.id} />
                ))}
            </div>
            <div className="side-bar side-bar-right"></div>
        </div>
    );
}

import { useEffect, useRef, useState } from "react";
import ChangeButton from "./ChangeButton.jsx";
import "./Line.css";

function change(keyValue, medal, operation) {
    fetch(`http://localhost:8080/country/${keyValue}/${medal}/${operation}`, {
        method: "PATCH"
    })
        .then((response) => console.log(response))
        .catch((error) => console.error("There's an error:", error));
}

export default function Line(props) {
    let background = props.number % 2 == 0 ? "#eaeaea" : "#444444";
    let textColor = props.number % 2 == 0 ? "#444444" : "#eaeaea";

    const [keyValue, setKeyValue] = useState(props.id);
    const [showChangeButton, setChangeButton] = useState(false);

    const outerDivRef = useRef(null);

    useEffect(() => {
        if (outerDivRef.current) {
            outerDivRef.current.addEventListener("mouseover", () => {
                setChangeButton(true);
            });

            outerDivRef.current.addEventListener("mouseout", () => {
                setChangeButton(false);
            });
        }
    }, [outerDivRef]);

    return (
        <div ref={outerDivRef} className="outer-div" style={{ backgroundColor: background, color: textColor }}>
            <div className="inner-div">
                <div className="div-content div-content-start">
                    <p className="number">{props.number}.</p>
                    <div className="outer-flag">
                        <img src={props.flagLink}></img>
                    </div>
                    <p id="name">{props.name}</p>
                </div>
                <div className="div-content div-content-end">
                    <div className="outer-number">
                        {showChangeButton && <ChangeButton type="increase" background={textColor} textColor={background} onClick={() => change(keyValue, "gold", "increase")} />}
                        <p className="number">{props.gold}</p>
                        {showChangeButton && <ChangeButton type="decrease" background={textColor} textColor={background} />}
                    </div>
                    <div className="outer-number">
                        {showChangeButton && <ChangeButton type="increase" background={textColor} textColor={background} />}
                        <p className="number">{props.silver}</p>
                        {showChangeButton && <ChangeButton type="decrease" background={textColor} textColor={background} />}
                    </div>
                    <div className="outer-number">
                        {showChangeButton && <ChangeButton type="increase" background={textColor} textColor={background} />}
                        <p className="number">{props.bronze}</p>
                        {showChangeButton && <ChangeButton type="decrease" background={textColor} textColor={background} />}
                    </div>
                    <p className="number">{props.all}</p>
                </div>
            </div>
        </div>
    );
}

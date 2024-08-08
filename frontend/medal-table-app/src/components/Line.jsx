import "./Line.css";

export default function Line(props) {
    let background = props.number % 2 == 0 ? "white" : "aqua";
    let textColor = props.number % 2 == 0 ? "aqua" : "white";

    return (
        <div className="outer-div" style={{ backgroundColor: background, color: textColor }}>
            <div className="inner-div">
                <div className="div-content div-content-start">
                    <p className="number">{props.number}.</p>
                    <img src={props.flagLink}></img>
                    <p id="name">{props.name}</p>
                </div>
                <div className="div-content div-content-end">
                    <p className="number">{props.gold}</p>
                    <p className="number">{props.silver}</p>
                    <p className="number">{props.bronze}</p>
                    <p className="number">{props.all}</p>
                </div>
            </div>
        </div>
    );
}

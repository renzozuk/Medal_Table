import "./Line.css";

function Line(props) {
    let background;
    let textColor;

    if (props.number % 2 == 0) {
        background = "white";
        textColor = "aqua";
    } else {
        background = "aqua";
        textColor = "white";
    }

    return (
        <div className="outer-div" id={props.id} style={{ backgroundColor: background, color: textColor }}>
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

export default Line;

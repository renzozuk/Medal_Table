import "./SequenceButton.css";

export default function SequenceButton(props) {
    return(
        <button className="button" onClick={props.onClick}>
            <div className="left-side">
                {props.image ? <img className="medal-button-image" src={props.content}></img> : <p className="button-text">{props.content}</p>}
            </div>
            {props.arrow && <div className="right-side">{props.reverse ? 
                <img className="arrow-image" src={"https://upload.wikimedia.org/wikipedia/commons/thumb/e/ed/Decrease2.svg/22px-Decrease2.svg.png"}></img> :
                <img className="arrow-image" src={"https://upload.wikimedia.org/wikipedia/commons/thumb/b/b0/Increase2.svg/22px-Increase2.svg.png"}></img> }
            </div>}
        </button>
    );
}
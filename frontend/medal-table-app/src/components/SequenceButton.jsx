import "./SequenceButton.css";

export default function SequenceButton(props) {
    return(
        <div className="button">
            <div className="left-side">
                {props.image ? <img className="medal-button-image" src={props.content}></img> : <p className="button-text">{props.content}</p>}
            </div>
            <div className="right-side">{props.arrow ? 
                <img className="arrow-image" src={"https://upload.wikimedia.org/wikipedia/commons/thumb/b/b0/Increase2.svg/22px-Increase2.svg.png"}></img> : 
                <img className="arrow-image" src={"https://upload.wikimedia.org/wikipedia/commons/thumb/e/ed/Decrease2.svg/22px-Decrease2.svg.png"}></img>}
            </div>   
        </div>
    );
}
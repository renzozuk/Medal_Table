import "./ChangeButton.css";

export default function ChangeButton(props) {
    return (
        <button className={`change-button ${props.type}-button`} style={{ backgroundColor: props.background, color: props.textColor, borderRadius: props.type === "decrease" ? "10% 10% 40% 40%" : "40% 40% 10% 10%" }} onClick={props.onClick}>
            {props.type === "increase" ? "+" : "-"}
        </button>
    )
}
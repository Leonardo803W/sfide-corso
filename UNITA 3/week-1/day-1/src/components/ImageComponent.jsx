import { Component } from "react";

class ImageComponent extends Component {
    render() {

        const {src, alt} = this.props

        return (
            <>
                <img src={src} alt={alt} className="rotating-image" />
            </>
        )
    }
}

export default ImageComponent
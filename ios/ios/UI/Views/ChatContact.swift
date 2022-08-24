import UIKit

class ChatContact: UIView {

    @IBOutlet weak var image: UIImageView!
    @IBOutlet weak var uname: UILabel!
    @IBOutlet weak var resentText: UILabel!
    @IBOutlet weak var timeSent: UILabel!
    
    
    @IBInspectable var resentTextV: String {
        get {
            return resentText.text ?? ""
        }
        set {
            resentText.text = newValue
        }
    }
    
    @IBInspectable var nameV: String {
        get {
            return uname.text ?? ""
        }
        set {
            uname.text = newValue
        }
    }
    
    @IBInspectable var imageV: UIImage {
        get {
            return image.image ?? UIImage.init(named: "ywoman")!
        }
        set {
            image.image = newValue
        }
    }
    
    
    @IBInspectable var timeSentV: String {
        get {
            return timeSent.text ?? ""
        }
        set {
            timeSent.text = newValue
        }
    }
    
    @IBOutlet var contentView: UIView!
    override init(frame: CGRect) {
        super.init(frame: frame)
        commonInit()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        commonInit()
    }
    
    private func commonInit(){
        Bundle.main.loadNibNamed("chat_contact", owner: self, options: nil)
        addSubview(contentView)
        contentView.frame  = self.bounds
        contentView.autoresizingMask = [.flexibleTopMargin, .flexibleBottomMargin, .flexibleLeftMargin , .flexibleRightMargin]
    }

}

import UIKit

class AppointmentV2: UIView {

    @IBOutlet weak var image: UIImageView!
    @IBOutlet weak var time: UILabel!
    @IBOutlet weak var visitType: UILabel!
    @IBOutlet weak var name: UILabel!
    @IBOutlet var contentView: UIView!
    
    @IBInspectable var nameV: String {
        get {
            return name.text ?? ""
        }
        set {
           name.text = newValue
        }
    }
    
    @IBInspectable var timeV: String {
        get {
            return time.text ?? ""
        }
        set {
            time.text = newValue
        }
    }
    
    @IBInspectable var imageV: UIImage {
        get {
            return image.image ?? UIImage.init(named: "yman")!
        }
        set {
            image.image = newValue
        }
    }
    
    @IBInspectable var visitTypeV: String {
        get {
            return visitType.text ?? ""
        }
        set {
            visitType.text = newValue
        }
    }
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        commonInit()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        commonInit()
    }
    
    private func commonInit(){
        Bundle.main.loadNibNamed("appointments", owner: self, options: nil)
        addSubview(contentView)
        contentView.frame  = self.bounds
        contentView.autoresizingMask = [.flexibleTopMargin, .flexibleBottomMargin, .flexibleLeftMargin , .flexibleRightMargin]
    }
}

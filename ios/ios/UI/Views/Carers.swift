import UIKit

class Carers: UIView {
    @IBOutlet var contentView: UIView!
    @IBOutlet weak var name: UILabel!
    @IBOutlet weak var timePay: UILabel!
    @IBOutlet weak var image: UIImageView!
    @IBOutlet weak var favorite: UIImageView!
    
    @IBInspectable var nameV: String {
        get {
            return name.text ?? ""
        }
        set {
           name.text = newValue
        }
    }
    
    @IBInspectable var timePayV: String {
        get {
            return timePay.text ?? ""
        }
        set {
            timePay.text = newValue
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
    
    private var _isFavorite = false
    @IBInspectable var isFavorite: Bool {
        get {
            return _isFavorite
        }
        set {
            
            if(newValue){
                favorite.image = UIImage.init(systemName: "heart.fill")
            } else {
                favorite.image = UIImage.init(systemName: "heart")
            }
            
            _isFavorite = newValue
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
        Bundle.main.loadNibNamed("carers", owner: self, options: nil)
        addSubview(contentView)
        contentView.frame  = self.bounds
        contentView.autoresizingMask = [.flexibleTopMargin, .flexibleBottomMargin, .flexibleLeftMargin , .flexibleRightMargin]
    }
}

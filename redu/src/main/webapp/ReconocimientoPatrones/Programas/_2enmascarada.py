from skimage.filters import threshold_otsu
from skimage.morphology import erosion, dilation, opening, closing, white_tophat
from skimage.morphology import disk, square, reconstruction

def morph_oper(img_in, kernel_size):
    thresh = threshold_otsu(img_in)*0.7
    i_bin = img_in > thresh
    kernel = disk(kernel_size)
    binary_mask = opening(i_bin,kernel)
    binary_mask = closing(binary_mask, kernel)

# Estos pasos para rellenar huecos
#     seed = np.copy(binary_mask)
#     seed[1:-1, 1:-1] = binary_mask.max()
#     filled_binary_mask = reconstruction(seed, binary_mask, method='erosion')
    filled_binary_mask = binary_mask
    return filled_binary_mask

# un kernel size de 18 se usa en el script original. Un kernel de 27 elimino el ruido en la imagen in.dcm
